(ns notification-system-clojure.channels.sms)

(defn send [user message]
  (println "Sending SMS to" (:phone user) ":" (:body message))
  true)
