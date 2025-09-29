(ns notification-system-clojure.channels.push)

(defn send [user message]
  (println "Sending Push to" (:name user) ":" (:body message))
  true)
