(ns github-diffpub.state
  (:require [integrant.core :as ig]
            [duratom.core :as duratom])
  (:import [duratom.core Duratom]))

(def init-state {})

(defn app [state req]
  (println {:state state :req req})
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defmethod ig/init-key :github-diffpub/state [_ {:keys [duratom]}]
(println {:duratom duratom })
  (let [args (conj duratom :init init-state)]
    (apply duratom/duratom args)))
