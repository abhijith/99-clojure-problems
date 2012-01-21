;; Remove the K'th element from a list.
;; Example:
;; * (remove-at '(a b c d) 2)
;; (A C D)

(defn remove-at
  ([[f & r :as coll] n cnt acc]
     (cond (empty? coll) (seq acc)
           (= n cnt)     (remove-at r n (inc cnt) acc)
           :else         (remove-at r n (inc cnt) (conj acc f))))
  ([coll n]
     (remove-at coll n 1 [])))
