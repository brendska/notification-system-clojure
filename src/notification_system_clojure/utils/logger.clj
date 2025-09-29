(ns notification-system-clojure.utils.logger)

(def log (atom []))

(defn log-notification [user message channel success?]
  (swap! log conj {:user (:name user)
                   :category (:category message)
                   :channel channel
                   :message (:body message)
                   :timestamp (java.util.Date.)
                   :success success?}))

(defn get-logs []
  @log)
