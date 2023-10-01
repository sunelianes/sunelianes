# Mitt program

Jeg bruker MVC (model, view, controller). I modellen min har jeg valgt å ha to brett, MineSweeperBoard som fungerer som basebrettet, og HiddenBoard som vil være over dette. I førstnevnte regnes det ut hvor bombene skal være og hvilke tall som skal stå i rutene, og alt dette endres ikke på etter at det er lagd. I HiddenBoard er de dekte rutene, som da kan åpnes eller settes flagg på. Alle endringer av denne skjer i modellen. Jeg har to controllere, en for musen og en for keyboardet. Alt tegnes i viewet. 

Når programmet åpnes er det bare å trykke på skjermen så starter spillet. 
Målet med spillet er å åpne alle de skjulte rutene, som ikke har en bombe bak seg. Spilleren trykker på en og en rute, her blir man møtt med tre forskjellige varianter. Enten så er det en bombe, da er spillet tapt. Det kan også være et tall, dette betyr hvor mange bomber som ruten berører. Står det 3, vil denne ruten ha 3 bomber i sin radius. En rutes radius er de åtte blokkene rundt ruten. Det siste alternativet er en tom rute, denne ruten berører ingen bomber. Ved åpning av en tom rute, vil alle andre tomme ruter rundt denne også åpnes, i tillegg vil de rutene rundt disse tomme rutene også åpnes. 

Det finnes også en funskjon for å markere hvor man tror det er bomber, dette gjøres ved å høyreklikke. Da kommer det ett flagg på ruten, men pass på! Antall flagg representerer også antall bomber på brettet, noe som vil si at hvis alle flaggene dine er brukt opp og du fortsatt ikke har vunnet, har du satt noe feil. Man kan da selvfølgelig fjerne flagg ved å høyreklikke igjen. En rute med flagg på kan ikke åpnes før flagget er tatt bort. Ved spillstart vil bombene genereres helt tilfeldig på brettet, etter antall. Under spillet kan man ved enhver tid trykke på 'p', da vil spillet settes på pause. For å starte spillet igjen, trykker man bare på 'p' igjen. Standardbrettet kommer med 30 miner, og 15*15 ruter. Hvis man endrer dette i main, vil spillet tilpasse seg.

https://vimeo.com/819045046?share=copy

