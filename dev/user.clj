(ns user
  (:require [integrant.core :as ig]
            [com.rpl.specter :refer :all]
            [clojure.pprint :as pprint]
            
              ; [clojure.alpha.spec :as s]
              ; [clojure.alpha.spec.gen :as gen]
              ; [clojure.alpha.spec.test :as test]

            [clojure.repl] ;; FIXME in cljsh
            [robert.hooke] ;; FIXME in cljsh
            [cljsh.source :refer [source-expand-ns]]
            [eftest.runner :refer [find-tests run-tests]]
            [clojure.java.io :as io]
            [clj-antlr.core :as antlr]
            [cljsh.complement]
            [clojure.edn :as edn]
            [clojure.string :as string]
            [jsonista.core :as j]
            [aprint.core :refer [aprint ap]]
            [integrant.repl :refer [clear halt go init prep suspend resume reset]]
            [clojure.tools.namespace.repl :as repl]
            [clojure.tools.namespace.find :as find]
            [github-diffpub.main]))

(defn read-edn-string [s]
  (binding [*data-readers* {'inst clojure.instant/read-instant-calendar}]
    (edn/read-string s)))

(integrant.repl/set-prep! #(github-diffpub.main/read-config "config.edn"))

(alter-var-root #'aprint.dispatch/*aprint-seq-length* (constantly 100))

(println "System: #'integrant.repl.state/system\nRun with (reset)\nRun tests: (run-tests (find-tests \"test\"))")

(comment
  )
