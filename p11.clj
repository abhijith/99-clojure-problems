;; Modified run-length encoding.
;; Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N E) lists.

;; Example:
;; * (encode-modified '(a a a a b c c a a d e e e e))
;; ((4 A) B (2 C) (2 A) D (4 E))

(defn- pack
  [cnt x]
  (if (= 1 cnt) x (list cnt x)))

(defn encode-mod
  ([[f & r :as coll] prev cnt acc]
     (cond (empty? coll)    (seq (conj acc (pack cnt prev)))
           (= prev f)       (encode-mod r f (inc cnt) acc)
           :else            (encode-mod r f 1 (conj acc (pack cnt prev)))))

  ([coll]
     (encode-mod coll (first coll) 0 [])))
