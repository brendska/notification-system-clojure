(ns notification-system-clojure.test-service
  (:require [clojure.test :refer :all]
            [notification-system-clojure.services.notification-service :as service]
            [notification-system-clojure.models.message :refer [->Message]]))

(deftest test-send-notification
  (testing "Send notification to subscribed users"
    (let [msg (->Message "1" "Sports" "Test message" (java.util.Date.))]
      (is (nil? (service/send-notification msg))))))
