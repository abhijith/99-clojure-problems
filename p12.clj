;; Decode a run-length encoded list.
;; Given a run-length code list generated as specified in problem P11. Construct its uncompressed version.

(defn decode
  [[[n element :as f] & r :as coll] acc]
  (if (empty? coll)
    acc
    (decode r (concat acc (repeat n element)))))
