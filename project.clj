(defproject fxdemo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories [["jzy3d-releases" "https://maven.jzy3d.org/releases"]]
  :aot [fxdemo.example1
        fxdemo.example2]
  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]
                 [org.jzy3d/jzy3d-api "1.0.0"]
                 [org.clojure/core.async "0.3.465"]])
