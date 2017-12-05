(ns fxdemo.core
  (:import   
    [javafx.application Application Platform]
    [javafx.stage Stage]
    [javafx.scene Scene]
    [javafx.scene.control Button]
    [javafx.scene.layout StackPane]
    [javafx.event ActionEvent EventHandler])
  (:require [clojure.core.async :as async]
            [fxdemo.appstate :as appstate]))

(def gui-channel (async/chan 3))

(defn test-gui-fun [this primaryStage]
  (let [root (doto (StackPane.)
               (-> (.getChildren)
                   (.add (Button. "Hello World!"))))]
    (doto primaryStage
      (.setScene (Scene. root 300 250))
      (.show))))

(defn main-loop [this prim-stage]
  (loop []
    (let [f (async/<!! gui-channel)]
      (when f
        (f this prim-stage)
        (recur)))))

(defn set-implicit-exit [value]
  (Platform/setImplicitExit value))

;; Call this later once the GUI is started
(defn testrun-gui []
  (set-implicit-exit false)
  (Platform/runLater
   (fn []
     (let [s (deref appstate/state)]
       (test-gui-fun (:app s) (:primary-stage s))))))
