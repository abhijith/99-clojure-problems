;; Rotate a list N places to the left.
;; Examples:
;; * (rotate '(a b c d e f g h) 3)
;; (D E F G H A B C)

;; * (rotate '(a b c d e f g h) -2)
;; (G H A B C D E F)

;; Hint: Use the predefined functions length and append, as well as the result of problem P17.

; if length == n -> get back the same list

(defn rotate
  ([[f & r :as coll] n cnt acc]
     (cond (empty? coll) acc
           (= n cnt)     (concat r (conj acc f))
           :else         (rotate r n (inc cnt) (conj acc f))))
  ([coll n]
     (rotate coll (mod n (count coll)) 1 [])))

(defn rotate
  [coll n]
  (let [n (mod n (count coll))
        [a b] (split-at n coll)]
    (concat b a)))
