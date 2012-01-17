;; Reverse a list.

(defn my-reverse
  [coll]
  (loop [[f & r :as c] coll acc '()]
    (if (empty? c)
      acc
      (recur r (cons f acc)))))
