# Ugly Trivia: Ejercicio código Legacy Ángel Viudez Martín

Autor: Ángel Viudez Martín
Curso: Postgrado PMA Metodologías Ágils (La Salle)
Fecha: 04/05/2013

## Descripción de la funcionalidad

La funcionalidad implementada consiste en acercar la funcionalidad al Trivial Pursuit real en los siguientes aspectos:
* 6 categorías de preguntas.
* Para ganar, hay que tener 6 "*quesitos*". Un quesito (*category score*), cuando se contesta correctamente a una pregunta, se gana un *quesito* de la categoría de la pregunta. No se puede acumular más de un quesito por categoría. Cuando se tiene un quesito de cada una de las categorías se gana el juego.
* Se han corregido los siguientes problemas encontrados:
  * El dado sólo daba valores del 1 al 5.
* En general, se ha refactorizado prácticamente todo el código, lo que ha propiciado que surgan las siguientes funcionalidades potenciales:
  * Posibilidad de implementar diferentes mecanismos de respuestas (interface `Responder`)
  * Posibilidad de usar dados de múltiples números caras.
  * Ahora puede jugar un número ilimitado de jugadores.



