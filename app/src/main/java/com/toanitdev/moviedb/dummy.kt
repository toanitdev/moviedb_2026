package com.toanitdev.moviedb

import com.google.gson.Gson
import com.toanitdev.moviedb.domain.models.Movie

val moviesJson = "[" +
    "{\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/6yeVcxFR0j08vlv2OlL6zbewm4D.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        28,\n" +
    "        878,\n" +
    "        53\n" +
    "      ],\n" +
    "      \"id\": 1265609,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"War Machine\",\n" +
    "      \"overview\": \"On one last grueling mission during Army Ranger training, a combat engineer must lead his unit in a fight against a giant otherworldly killing machine.\",\n" +
    "      \"popularity\": 420.4551,\n" +
    "      \"poster_path\": \"/tlPgDzwIE7VYYIIAGCTUOnN4wI1.jpg\",\n" +
    "      \"release_date\": \"2026-02-12\",\n" +
    "      \"title\": \"War Machine\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7.221,\n" +
    "      \"vote_count\": 894\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/u6YE4rlEWOiYoqhPJuNvt5GHxgu.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        28,\n" +
    "        80,\n" +
    "        53\n" +
    "      ],\n" +
    "      \"id\": 1290821,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Shelter\",\n" +
    "      \"overview\": \"A man living in self-imposed exile on a remote island rescues a young girl from a violent storm, setting off a chain of events that forces him out of seclusion to protect her from enemies tied to his past.\",\n" +
    "      \"popularity\": 293.8073,\n" +
    "      \"poster_path\": \"/buPFnHZ3xQy6vZEHxbHgL1Pc6CR.jpg\",\n" +
    "      \"release_date\": \"2026-01-28\",\n" +
    "      \"title\": \"Shelter\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 6.606,\n" +
    "      \"vote_count\": 312\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/zpEWFNqoN8Qg1SzMMHmaGyOBTdW.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        53,\n" +
    "        80,\n" +
    "        35\n" +
    "      ],\n" +
    "      \"id\": 1054867,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"One Battle After Another\",\n" +
    "      \"overview\": \"Washed-up revolutionary Bob exists in a state of stoned paranoia, surviving off-grid with his spirited, self-reliant daughter, Willa. When his evil nemesis resurfaces after 16 years and she goes missing, the former radical scrambles to find her, father and daughter both battling the consequences of his past.\",\n" +
    "      \"popularity\": 161.5299,\n" +
    "      \"poster_path\": \"/lbBWwxBht4JFP5PsuJ5onpMqugW.jpg\",\n" +
    "      \"release_date\": \"2025-09-23\",\n" +
    "      \"title\": \"One Battle After Another\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7.399,\n" +
    "      \"vote_count\": 3133\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/hYgUkH7TusddHRtelj53I6gFOWR.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        28,\n" +
    "        53\n" +
    "      ],\n" +
    "      \"id\": 799882,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"The Bluff\",\n" +
    "      \"overview\": \"When her tranquil life on a remote island is shattered by the return of her vengeful former captain, a skilled ex-pirate must confront her bloody past and unleash her deadly talents to save her family from a ruthless siege.\",\n" +
    "      \"popularity\": 179.6941,\n" +
    "      \"poster_path\": \"/w0jwjFmRu2or7LQqh1tSMFjq0At.jpg\",\n" +
    "      \"release_date\": \"2026-02-17\",\n" +
    "      \"title\": \"The Bluff\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 6.311,\n" +
    "      \"vote_count\": 275\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/1x9e0qWonw634NhIsRdvnneeqvN.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        10749,\n" +
    "        18\n" +
    "      ],\n" +
    "      \"id\": 1523145,\n" +
    "      \"original_language\": \"ru\",\n" +
    "      \"original_title\": \"Твое сердце будет разбито\",\n" +
    "      \"overview\": \"High school student Polina is saved from bullying at her new school and makes a deal with the main bully Bars: he must pretend to be her boyfriend and protect her, and she must do everything he says. During this game, the couple develops real feelings, but her family and classmates have reasons to separate the lovers.\",\n" +
    "      \"popularity\": 192.9655,\n" +
    "      \"poster_path\": \"/iGpMm603GUKH2SiXB2S5m4sZ17t.jpg\",\n" +
    "      \"release_date\": \"2026-03-26\",\n" +
    "      \"title\": \"Your Heart Will Be Broken\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 0,\n" +
    "      \"vote_count\": 0\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/lgotja3xMoJZbynwHfcQcJAEMWH.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        16,\n" +
    "        35,\n" +
    "        12,\n" +
    "        10751,\n" +
    "        9648\n" +
    "      ],\n" +
    "      \"id\": 1084242,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Zootopia 2\",\n" +
    "      \"overview\": \"After cracking the biggest case in Zootopia's history, rookie cops Judy Hopps and Nick Wilde find themselves on the twisting trail of a great mystery when Gary De'Snake arrives and turns the animal metropolis upside down. To crack the case, Judy and Nick must go undercover to unexpected new parts of town, where their growing partnership is tested like never before.\",\n" +
    "      \"popularity\": 167.8774,\n" +
    "      \"poster_path\": \"/oJ7g2CifqpStmoYQyaLQgEU32qO.jpg\",\n" +
    "      \"release_date\": \"2025-11-26\",\n" +
    "      \"title\": \"Zootopia 2\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7.606,\n" +
    "      \"vote_count\": 2199\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/2RrLuIfIzGWWIH8IAEo6o0IYHmx.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        16,\n" +
    "        10751,\n" +
    "        878,\n" +
    "        35\n" +
    "      ],\n" +
    "      \"id\": 1327819,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Hoppers\",\n" +
    "      \"overview\": \"Scientists have discovered how to 'hop' human consciousness into lifelike robotic animals, allowing people to communicate with animals as animals. Animal lover Mabel seizes an opportunity to use the technology, uncovering mysteries within the animal world beyond anything she could have imagined.\",\n" +
    "      \"popularity\": 139.6683,\n" +
    "      \"poster_path\": \"/xjtWQ2CL1mpmMNwuU5HeS4Iuwuu.jpg\",\n" +
    "      \"release_date\": \"2026-03-04\",\n" +
    "      \"title\": \"Hoppers\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7.729,\n" +
    "      \"vote_count\": 203\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/u9jE0R1nvkmdWu3bt7Op8joPywa.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        12,\n" +
    "        53,\n" +
    "        878\n" +
    "      ],\n" +
    "      \"id\": 840464,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Greenland 2: Migration\",\n" +
    "      \"overview\": \"Having found the safety of the Greenland bunker after the comet Clarke decimated the Earth, the Garrity family must now risk everything to embark on a perilous journey across the wasteland of Europe to find a new home.\",\n" +
    "      \"popularity\": 133.9738,\n" +
    "      \"poster_path\": \"/z2tqCJLsw6uEJ8nJV8BsQXGa3dr.jpg\",\n" +
    "      \"release_date\": \"2026-01-07\",\n" +
    "      \"title\": \"Greenland 2: Migration\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 6.428,\n" +
    "      \"vote_count\": 616\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/nAxGnGHOsfzufThz20zgmRwKur3.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        27,\n" +
    "        28,\n" +
    "        53\n" +
    "      ],\n" +
    "      \"id\": 1233413,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Sinners\",\n" +
    "      \"overview\": \"Trying to leave their troubled lives behind, twin brothers return to their hometown to start again, only to discover that an even greater evil is waiting to welcome them back.\",\n" +
    "      \"popularity\": 118.9237,\n" +
    "      \"poster_path\": \"/fWPgbnt2LSqkQ6cdQc0SZN9CpLm.jpg\",\n" +
    "      \"release_date\": \"2025-04-16\",\n" +
    "      \"title\": \"Sinners\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7.475,\n" +
    "      \"vote_count\": 4023\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/7HKpc11uQfxnw0Y8tRUYn1fsKqE.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        878,\n" +
    "        28,\n" +
    "        53\n" +
    "      ],\n" +
    "      \"id\": 1236153,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Mercy\",\n" +
    "      \"overview\": \"In the near future, a detective stands on trial accused of murdering his wife. He has ninety minutes to prove his innocence to the advanced AI Judge he once championed, before it determines his fate.\",\n" +
    "      \"popularity\": 124.256,\n" +
    "      \"poster_path\": \"/pyok1kZJCfyuFapYXzHcy7BLlQa.jpg\",\n" +
    "      \"release_date\": \"2026-01-20\",\n" +
    "      \"title\": \"Mercy\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7.085,\n" +
    "      \"vote_count\": 743\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/1gLFGrxHqQebqLWpISmoFR6XWtJ.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        28,\n" +
    "        53\n" +
    "      ],\n" +
    "      \"id\": 1088434,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Hellfire\",\n" +
    "      \"overview\": \"A drifter with a mysterious past arrives in a small town and finds the residents in the grip of a ruthless crime boss and realizes he has to help them.\",\n" +
    "      \"popularity\": 111.5689,\n" +
    "      \"poster_path\": \"/tQti9QTf13MfzNpXguijgNh7ojE.jpg\",\n" +
    "      \"release_date\": \"2026-02-05\",\n" +
    "      \"title\": \"Hellfire\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 6.904,\n" +
    "      \"vote_count\": 57\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/cz4vLJrmaV1zJlRYbxqtvLzeLWB.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        28,\n" +
    "        35,\n" +
    "        80,\n" +
    "        9648\n" +
    "      ],\n" +
    "      \"id\": 1168190,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"The Wrecking Crew\",\n" +
    "      \"overview\": \"Estranged half-brothers Jonny and James reunite after their father's mysterious death. As they search for the truth, buried secrets reveal a conspiracy threatening to tear their family apart.\",\n" +
    "      \"popularity\": 105.9643,\n" +
    "      \"poster_path\": \"/gbVwHl4YPSq6BcC92TQpe7qUTh6.jpg\",\n" +
    "      \"release_date\": \"2026-01-28\",\n" +
    "      \"title\": \"The Wrecking Crew\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 6.878,\n" +
    "      \"vote_count\": 788\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/yJi6g0CnsqANLNuVaRX28tZxeHX.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        27,\n" +
    "        9648\n" +
    "      ],\n" +
    "      \"id\": 1193501,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Whistle\",\n" +
    "      \"overview\": \"A misfit group of unwitting high school students stumble upon a cursed object, an ancient Aztec Death Whistle. They discover that blowing the whistle and the terrifying sound it emits will summon their future deaths to hunt them down.\",\n" +
    "      \"popularity\": 99.534,\n" +
    "      \"poster_path\": \"/84vAcFwxoObBuMWANWQXCg0Umg8.jpg\",\n" +
    "      \"release_date\": \"2026-01-20\",\n" +
    "      \"title\": \"Whistle\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 6.112,\n" +
    "      \"vote_count\": 152\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/sdZSjtGUTSN8B3al5o0f2WoQfQQ.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        878,\n" +
    "        12,\n" +
    "        14\n" +
    "      ],\n" +
    "      \"id\": 83533,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Avatar: Fire and Ash\",\n" +
    "      \"overview\": \"In the wake of the devastating war against the RDA and the loss of their eldest son, Jake Sully and Neytiri face a new threat on Pandora: the Ash People, a violent and power-hungry Na'vi tribe led by the ruthless Varang. Jake's family must fight for their survival and the future of Pandora in a conflict that pushes them to their emotional and physical limits.\",\n" +
    "      \"popularity\": 93.7636,\n" +
    "      \"poster_path\": \"/bRBeSHfGHwkEpImlhxPmOcUsaeg.jpg\",\n" +
    "      \"release_date\": \"2025-12-17\",\n" +
    "      \"title\": \"Avatar: Fire and Ash\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7.263,\n" +
    "      \"vote_count\": 1895\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/vSQSYd2zZTqc0zmHImwWEGGluMI.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        10749,\n" +
    "        18\n" +
    "      ],\n" +
    "      \"id\": 1316092,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"\\\"Wuthering Heights\\\"\",\n" +
    "      \"overview\": \"Tragedy strikes when Heathcliff falls in love with Catherine Earnshaw, a woman from a wealthy family in 18th-century England.\",\n" +
    "      \"popularity\": 108.9217,\n" +
    "      \"poster_path\": \"/3YBce6dTh1D5oCMITXk2S5QhPt.jpg\",\n" +
    "      \"release_date\": \"2026-02-11\",\n" +
    "      \"title\": \"\\\"Wuthering Heights\\\"\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 6.3,\n" +
    "      \"vote_count\": 518\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/52AkwEfQiJl2HuTPMZ2yC5Bdr9I.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        80,\n" +
    "        53\n" +
    "      ],\n" +
    "      \"id\": 1171145,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Crime 101\",\n" +
    "      \"overview\": \"When an elusive thief whose high-stakes heists unfold along the iconic 101 freeway in Los Angeles eyes the score of a lifetime, with hopes of this being his final job, his path collides with a disillusioned insurance broker who is facing her own crossroads. Determined to crack the case, a relentless detective closes in on the operation, raising the stakes even higher.\",\n" +
    "      \"popularity\": 140.535,\n" +
    "      \"poster_path\": \"/heMdO64ys1hR896YE2jvTv8JlBX.jpg\",\n" +
    "      \"release_date\": \"2026-02-11\",\n" +
    "      \"title\": \"Crime 101\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7.1,\n" +
    "      \"vote_count\": 178\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/drRxbu2OHG0DEENptZ8wI5f0uEU.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        878,\n" +
    "        28,\n" +
    "        35\n" +
    "      ],\n" +
    "      \"id\": 1119449,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Good Luck, Have Fun, Don't Die\",\n" +
    "      \"overview\": \"A 'Man from the Future' arrives at an LA diner where he must recruit the precise combination of disgruntled patrons to join him on a one-night quest to save the world from the terminal threat of a rogue artificial intelligence.\",\n" +
    "      \"popularity\": 89.3431,\n" +
    "      \"poster_path\": \"/rWcfOdY7TU6lTdazWj0ebDZnAfO.jpg\",\n" +
    "      \"release_date\": \"2026-02-13\",\n" +
    "      \"title\": \"Good Luck, Have Fun, Don't Die\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7.021,\n" +
    "      \"vote_count\": 167\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/lmns2jlRmATs8OGWKcCkgrbHLM4.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        28,\n" +
    "        18\n" +
    "      ],\n" +
    "      \"id\": 1634301,\n" +
    "      \"original_language\": \"te\",\n" +
    "      \"original_title\": \"Vanaveera\",\n" +
    "      \"overview\": \"A descendant of the Vanara clan is pushed into conflict when a modern-day Ravana seizes his only bike for an election rally. What starts as a petty injustice soon erupts into a fierce fight for self-respect and dignity.\",\n" +
    "      \"popularity\": 93.9414,\n" +
    "      \"poster_path\": \"/oBYExKI8E3bTzQjPkofhpV2EJon.jpg\",\n" +
    "      \"release_date\": \"2026-02-13\",\n" +
    "      \"title\": \"Vanaveera\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 7,\n" +
    "      \"vote_count\": 3\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/ibK0sooxQwIeqS9tz4Tj0chyca9.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        27,\n" +
    "        53\n" +
    "      ],\n" +
    "      \"id\": 1058710,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Bloodline Killer\",\n" +
    "      \"overview\": \"Moira Cole endeavors to rebuild her shattered life after her family's murder at the hands of her deranged and obsessed cousin.\",\n" +
    "      \"popularity\": 100.1222,\n" +
    "      \"poster_path\": \"/wHmzCQwBzT6m8wtZdXHOIITn82B.jpg\",\n" +
    "      \"release_date\": \"2024-04-26\",\n" +
    "      \"title\": \"Bloodline Killer\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 5.714,\n" +
    "      \"vote_count\": 42\n" +
    "    },\n" +
    "    {\n" +
    "      \"adult\": false,\n" +
    "      \"backdrop_path\": \"/8Tfys3mDZVp4tNoH2ktm06a0Tau.jpg\",\n" +
    "      \"genre_ids\": [\n" +
    "        878,\n" +
    "        12,\n" +
    "        9648\n" +
    "      ],\n" +
    "      \"id\": 687163,\n" +
    "      \"original_language\": \"en\",\n" +
    "      \"original_title\": \"Project Hail Mary\",\n" +
    "      \"overview\": \"Science teacher Ryland Grace wakes up on a spaceship light years from home with no recollection of who he is or how he got there. As his memory returns, he begins to uncover his mission: solve the riddle of the mysterious substance causing the sun to die out. He must call on his scientific knowledge and unorthodox ideas to save everything on Earth from extinction… but an unexpected friendship means he may not have to do it alone.\",\n" +
    "      \"popularity\": 152.0097,\n" +
    "      \"poster_path\": \"/cCx1m530ph5FmtabVVUpUchEmhe.jpg\",\n" +
    "      \"release_date\": \"2026-03-15\",\n" +
    "      \"title\": \"Project Hail Mary\",\n" +
    "      \"video\": false,\n" +
    "      \"vote_average\": 8.4,\n" +
    "      \"vote_count\": 57\n" +
    "    }]"

val movies = Gson().fromJson(moviesJson, Array<Movie>::class.java).toList()