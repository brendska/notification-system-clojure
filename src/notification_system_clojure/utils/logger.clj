(ns notification-system-clojure.utils.logger)

(def logs (atom []))

(defn log [entry]
  (swap! logs conj entry))

(defn get-logs []
  (reverse @logs))
