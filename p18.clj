;; Extract a slice from a list.
;; Given two indices, I and K, the slice is the list containing the elements between the I'th and K'th element of the original list (both limits included). Start counting the elements with 1.

;; Example:
;; * (slice '(a b c d e f g h i k) 3 7)
;; (C D E F G)

(defn- between?
  [x s e]
  (and (>= x s) (<= x e)))

(defn slice
  ([[f & r :as coll] s e cnt acc]
     (cond (empty? coll) acc
           (between? cnt s e) (slice r s e (inc cnt) (conj acc f))
           :else (slice r s e (inc cnt) acc)))
  ([coll s e]
     (slice coll s e 1 [])))
