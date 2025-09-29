(ns notification-system-clojure.models.user)

(def users
  [{:id 1
    :name "Brenda"
    :email "brenda@mail.com"
    :phone "+123456789"
    :subscribed ["Sports" "Finance"]
    :channels ["Email" "Push"]}

   {:id 2
    :name "Caio"
    :email "caio@mail.com"
    :phone "+987654321"
    :subscribed ["Movies"]
    :channels ["SMS" "Email"]}])
