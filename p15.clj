;; Replicate the elements of a list a given number of times.
;; Example:
;; * (repli '(a b c) 3)
;; (A A A B B B C C C)

(defn repli
  ([[f & r :as coll] n acc]
     (if (empty? coll)
       (seq acc)
       (repli r n (concat acc (repeat n f)))))
    ([coll n]
     (repli coll n [])))
