(ns github-diffpub.state
  (:require [integrant.core :as ig]
            [duratom.core :as duratom])
  (:import [duratom.core Duratom]))

(def init-state {})

(use 'aprint.core)
(defn app [state req]
  (aprint {:state state :req req :body (some-> req :body slurp)})
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defmethod ig/init-key :github-diffpub/state [_ {:keys [duratom]}]
(println {:duratom duratom })
  (let [args (conj duratom :init init-state)]
    (apply duratom/duratom args)))
