(ns notification-system-clojure.channels.email)

(defn send [user message]
  (println "Sending Email to" (:email user) ":" (:body message))
  true)
