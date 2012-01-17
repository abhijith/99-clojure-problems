;; Find the K'th element of a list.
;; The first element in the list is number 1.
;; Example:
;; * (element-at '(a b c d e) 3)
;; C

(defn element-at
  [coll n]
  (loop [[f & r] coll cnt 1]
    (if (= cnt n)
      f
      (recur r (inc cnt)))))
