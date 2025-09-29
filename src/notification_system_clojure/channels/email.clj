(ns notification-system-clojure.channels.email)

(defn send-email [user message]
  (println "Sending Email to" (:email user) ":" (:body message))
  true)
