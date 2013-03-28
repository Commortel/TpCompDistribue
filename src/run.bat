javac -cp . serveur/*.java
rmic -classpath . serveur.TchatServeur
rmic -classpath . serveur.TchatClient
start rmiregistry
java -cp . serveur.TchatServeur
