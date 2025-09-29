(ns notification-system-clojure.controllers.notification-controller
  (:require [notification-system-clojure.services.notification-service :as service]
            [notification-system-clojure.models.message :refer [->Message]]
            [ring.util.response :as response]
            [clojure.string :as str]
            [clojure.uuid :as uuid]))

(defn send-message [req]
  (let [{:keys [category body]} (:params req)]
    (if (or (str/blank? category) (str/blank? body))
      (response/bad-request {:error "Category and body cannot be empty"})
      (let [msg (->Message (str (uuid/random-uuid)) category body (java.util.Date.))]
        (service/send-notification msg)
        (response/response {:success true :message msg})))))
