(ns notification-system-clojure.test-controller
  (:require [clojure.test :refer :all]
            [notification-system-clojure.controllers.notification-controller :as controller]
            [notification-system-clojure.models.message :refer [->Message]]))

(deftest test-send-message
  (testing "Send message with valid params"
    (let [req {:params {:category "Sports" :body "Hello"}}
          resp (controller/send-message req)]
      (is (= 200 (:status resp)))))

  (testing "Send message with empty body"
    (let [req {:params {:category "Sports" :body ""}}
          resp (controller/send-message req)]
      (is (= 400 (:status resp))))))
