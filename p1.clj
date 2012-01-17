;; Find the last box of a list.
;; Example:
;; * (my-last '(a b c d))
;; (D)

(defn my-last
  [coll]
  (loop [[f & r] coll]
    (if (empty? r)
      f
      (recur r))))

(defn my-last
  [[f & r :as coll]]
  (if (empty? r)
    f
    (recur r)))
