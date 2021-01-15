(ns github-diffpub.http
  (:require [integrant.core :as ig]
            [org.httpkit.server :refer [run-server]]
            [github-diffpub.state :as state]))

(defmethod ig/init-key :github-diffpub/http [_ {:keys [state server] :as opts}]
  (run-server (partial state/app state) server))

(defmethod ig/halt-key! :github-diffpub/http [_ httpkit]
  (httpkit :timeout 100))
