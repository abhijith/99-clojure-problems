;; Duplicate the elements of a list.
;; Example:
;; * (dupli '(a b c c d))
;; (A A B B C C C C D D)

(defn dupli
  ([[f & r :as coll] acc] 
     (if (empty? coll)
       (seq acc)
       (dupli r (concat acc (repeat 2 f)))))
  ([coll]
     (dupli coll [])))
        
