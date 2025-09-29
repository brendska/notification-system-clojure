(ns notification-system-clojure.channels.push)

(defn send-push [user message]
  (println "Sending Push Notification to" (:name user) ":" (:body message))
  true)
