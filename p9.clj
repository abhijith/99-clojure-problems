;; Pack consecutive duplicates of list elements into sublists.
;; If a list contains repeated elements they should be placed in separate sublists.

;; Example:
;; * (pack '(a a a a b c c a a d e e e e))
;; ((A A A A) (B) (C C) (A A) (D) (E E E E))

(defn my-pack
  [[f & r :as coll] prev tmp acc]
  (cond (empty? coll) (seq (conj acc (seq tmp)))
        (= prev f) (my-pack r f (conj tmp f) acc)
        (not (= prev f)) (my-pack r f (conj [] f) (conj acc (seq tmp)))))
        

