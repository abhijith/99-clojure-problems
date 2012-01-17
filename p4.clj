;; Find the number of elements of a list.

(defn my-count
  [coll]
  (loop [[f & r] coll cnt 1]
    (if-not (empty? coll)
      (if (empty? r)
        cnt
        (recur r (inc cnt)))
      0)))
