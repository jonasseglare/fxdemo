(ns fxdemo.example2
  (:import
    [javafx.application Application]
    [javafx.stage Stage]
    [javafx.scene Scene]
    [javafx.scene.control Button]
    [javafx.scene.layout StackPane]
    [javafx.event ActionEvent EventHandler])
  (:gen-class
   :extends javafx.application.Application)
  (:require [fxdemo.core :as core]
            [clojure.core.async :as async]
            [fxdemo.appstate :as appstate]))

(defn -main [& args]
  (Application/launch fxdemo.example2 args))

(defn main-async [& args]
  (future (Application/launch fxdemo.example2 args)))

(defn -start [this primaryStage]
  (reset! appstate/state {:app this
                          :primary-stage primaryStage}))
