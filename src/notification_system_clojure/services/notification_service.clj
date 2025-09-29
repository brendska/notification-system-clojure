(ns notification-system-clojure.services.notification-service
  (:require [notification-system-clojure.models.user :refer [users]]
            [notification-system-clojure.channels.sms :as sms]
            [notification-system-clojure.channels.email :as email]
            [notification-system-clojure.channels.push :as push]
            [notification-system-clojure.utils.logger :as logger]))

(def channels-map {"SMS" sms/send
                   "Email" email/send
                   "Push" push/send})

(defn send-notification [message]
  (doseq [user (filter #(some #{(:category message)} (:subscribed %)) users)]
    (doseq [channel-name (:channels user)]
      (when-let [f (get channels-map channel-name)]
        (let [success (f user message)]
          (logger/log {:user-id (:id user)
                       :channel channel-name
                       :message (:body message)
                       :timestamp (:timestamp message)
                       :success success}))))))

