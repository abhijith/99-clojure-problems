;; Run-length encoding of a list (direct solution).
;; Implement the so-called run-length encoding data compression method directly. I.e. don't explicitly create the sublists containing the duplicates, as in problem P09, but only count them. As in problem P11, simplify the result list by replacing the singleton lists (1 X) by X.

;; Example:
;; * (encode-direct '(a a a a b c c a a d e e e e))
;; ((4 A) B (2 C) (2 A) D (4 E))

(defn- pack
  [n element]
  (if (= n 1)
    element
    (repeat n element)))

(defn encode-direct
  ([[f & r :as coll] prev cnt acc]
     (cond (empty? coll)    (seq (conj acc (pack cnt prev)))
           (= prev f)       (encode-direct r f (inc cnt) acc)
           :else            (encode-direct r f 1 (conj acc (pack cnt prev)))))

  ([coll]
     (encode-direct coll (first coll) 0 [])))
