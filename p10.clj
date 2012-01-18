;; Run-length encoding of a list.
;; Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as lists (N E) where N is the number of duplicates of the element E.

;; Example:
;; * (encode '(a a a a b c c a a d e e e e))
;; ((4 A) (1 B) (2 C) (2 A) (1 D)(4 E))

(defn- pack
  [cnt x]
  (list cnt x))

(defn encode
  ([[f & r :as coll] prev cnt acc]
     (cond (empty? coll)    (seq (conj acc (pack cnt prev)))
           (= prev f)       (encode-mod r f (inc cnt) acc)
           :else            (encode-mod r f 1 (conj acc (pack cnt prev)))))

  ([coll]
     (encode-mod coll (first coll) 0 [])))
