(ns github-diffpub.main
  (:require [integrant.core :as ig])
  (:gen-class))

(defn read-config [config-fname]
  (ig/read-string (slurp config-fname)))

(defn -main [& args]
  (-> args first (or "config.edn") read-config ig/init))
