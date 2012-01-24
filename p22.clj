;; Create a list containing all integers within a given range.
;; If first argument is smaller than second, produce a list in decreasing order.
;; Example:
;; * (range 4 9)
;; (4 5 6 7 8 9)

(defn- between?
  [x s e]
  (and (>= x s) (<= x e)))

(defn my-range
  ([s e cnt acc]
     (cond (> cnt e) (seq acc)
           (between? cnt s e) (my-range s e (inc cnt) (conj acc cnt))
           :else (my-range s e (inc cnt) acc)))
  ([s e]
     (my-range s e s [])))
