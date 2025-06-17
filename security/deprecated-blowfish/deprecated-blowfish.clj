(ns deprecated-blowfish
  (:import [javax.crypto Cipher]))

(defn vulnerable []
  (Cipher/getInstance "blowfish"))

(defn not-vulnerable []
  (Cipher/getInstance "RSA/CBC/PKCS1Padding"))
