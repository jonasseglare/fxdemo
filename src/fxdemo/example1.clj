(ns fxdemo.example1
  (:import
    [javafx.application Application]
    [javafx.stage Stage]
    [javafx.scene Scene]
    [javafx.scene.control Button]
    [javafx.scene.layout StackPane]
    [javafx.event ActionEvent EventHandler])
  (:gen-class
    :extends javafx.application.Application))

(defn -main [& args]
  (Application/launch fxdemo.example1 args))

(defn -start [this primaryStage]
  (let [root (doto (StackPane.)
               (-> (.getChildren)
                   (.add (Button. "Hello World!"))))]
    (doto primaryStage
      (.setScene (Scene. root 300 250))
      (.show))))
