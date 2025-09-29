(ns notification-system-clojure.test-controller
  (:require [clojure.test :refer :all]
            [notification-system-clojure.controllers.notification-controller :as controller]
            [ring.mock.request :as mock]
            [notification-system-clojure.models.message :refer [->Message]]))

(deftest test-send-message
  (testing "Send message with valid params"
    (let [req (mock/request :post "/send" {:category "Sports" :body "Hello"})]
      (let [resp (controller/send-message req)]
        (is (= 200 (:status resp))))))

  (testing "Send message with empty body"
    (let [req (mock/request :post "/send" {:category "Sports" :body ""})]
      (let [resp (controller/send-message req)]
        (is (= 400 (:status resp)))))))
