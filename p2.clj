;; Find the last but one box of a list.
;; Example:
;; * (my-but-last '(a b c d))
;; (C D)

(defn my-but-last
  [coll]
  (loop [[f & r] coll]
    (if (empty? (rest (rest r)))
      r
      (recur r))))

(defn my-but-last
  [[f & r :as coll]]
  (if (empty? (rest (rest r)))
    r
    (recur r)))
