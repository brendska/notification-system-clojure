(ns notification-system-clojure.test-channels
  (:require [clojure.test :refer :all]
            [notification-system-clojure.channels.sms :as sms]
            [notification-system-clojure.channels.email :as email]
            [notification-system-clojure.channels.push :as push]
            [notification-system-clojure.models.user :refer [users]]
            [notification-system-clojure.models.message :refer [->Message]]))

(deftest test-sms
  (testing "SMS channel"
    (let [msg (->Message "1" "Movies" "Hello SMS" (java.util.Date.))]
      (is (true? (sms/send-sms (first users) msg))))))

(deftest test-email
  (testing "Email channel"
    (let [msg (->Message "2" "Finance" "Hello Email" (java.util.Date.))]
      (is (true? (email/send-email (first users) msg))))))

(deftest test-push
  (testing "Push channel"
    (let [msg (->Message "3" "Sports" "Hello Push" (java.util.Date.))]
      (is (true? (push/send-push (first users) msg))))))
