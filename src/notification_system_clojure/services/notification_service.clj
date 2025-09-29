(ns notification-system-clojure.services.notification-service
  (:require [notification-system-clojure.channels.sms :as sms]
            [notification-system-clojure.channels.email :as email]
            [notification-system-clojure.channels.push :as push]
            [notification-system-clojure.utils.logger :as logger]
            [notification-system-clojure.models.user :refer [users]]))

(def channels-map
  {"SMS" sms/send-sms
   "Email" email/send-email
   "Push" push/send-push})

(defn send-notification [message]
  (doseq [user users
          :when (some #(= (:category message) %) (:subscribed user))]
    (doseq [ch (:channels user)]
      (when-let [f (get channels-map ch)]
        (let [result (f user message)]
          (logger/log-notification user message ch result))))))
