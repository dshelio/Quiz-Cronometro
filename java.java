// Perguntas e respostas do quiz sobre a Bíblia
const questions = [
    {
        question: "Quem foi o primeiro homem criado por Deus?",
        answers: ["Adão", "Moisés", "Abraão", "Noé"],
        correctAnswer: 0
    },
    {
        question: "Qual é o primeiro livro da Bíblia?",
        answers: ["Gênesis", "Êxodo", "Levítico", "Deuteronômio"],
        correctAnswer: 0
    },
    {
        question: "Quem traiu Jesus?",
        answers: ["Pedro", "João", "Judas", "Tomé"],
        correctAnswer: 2
    },
    {
        question: "Quem foi o líder que conduziu os israelitas na saída do Egito?",
        answers: ["Moisés", "Josué", "Davi", "Salomão"],
        correctAnswer: 0
    },
    {
        question: "Quantos livros há no Antigo Testamento?",
        answers: ["39", "27", "66", "52"],
        correctAnswer: 0
    },
    {
        question: "Qual é o último livro da Bíblia?",
        answers: ["Apocalipse", "Atos", "Mateus", "João"],
        correctAnswer: 0
    },
    {
        question: "Quem escreveu os Salmos?",
        answers: ["Moisés", "Davi", "Isaías", "Salomão"],
        correctAnswer: 1
    },
    {
        question: "Quantos discípulos Jesus tinha?",
        answers: ["12", "10", "8", "20"],
        correctAnswer: 0
    },
    {
        question: "Onde Jesus nasceu?",
        answers: ["Nazaré", "Jerusalém", "Belém", "Capernaum"],
        correctAnswer: 2
    },
    {
        question: "Quem é conhecido como o 'Apóstolo dos Gentios'?",
        answers: ["Pedro", "João", "Paulo", "Tiago"],
        correctAnswer: 2
    },
    {
        question: "Qual é o versículo mais conhecido da Bíblia?",
        answers: ["João 3:16", "Salmo 23:1", "Gênesis 1:1", "Mateus 5:9"],
        correctAnswer: 0
    },
    {
        question: "Qual era o nome do pai de João Batista?",
        answers: ["Zacarias", "José", "Simão", "Abraham"],
        correctAnswer: 0
    },
    {
        question: "Quem foi lançado na cova dos leões por orar a Deus?",
        answers: ["Daniel", "Moisés", "Davi", "Isaías"],
        correctAnswer: 0
    },
    {
        question: "Quantos dias e noites choveu durante o Dilúvio?",
        answers: ["40", "100", "7", "14"],
        correctAnswer: 0
    },
    {
        question: "Quem foi a esposa de Abraão?",
        answers: ["Sara", "Raquel", "Débora", "Isabel"],
        correctAnswer: 0
    },
    {
        question: "Qual foi a última praga no Egito antes da libertação dos israelitas?",
        answers: ["A morte dos primogênitos", "Rãs", "Piolhos", "Moscas"],
        correctAnswer: 0
    },
    {
        question: "Quem matou Golias?",
        answers: ["Davi", "Saul", "Elias", "Moisés"],
        correctAnswer: 0
    },
    {
        question: "Onde Moisés recebeu os Dez Mandamentos?",
        answers: ["Monte Sinai", "Monte Carmelo", "Monte Hermom", "Monte Ararat"],
        correctAnswer: 0
    },
    {
        question: "Quem foi o profeta que desafiou os profetas de Baal no Monte Carmelo?",
        answers: ["Elias", "Eliseu", "Isaías", "Jeremias"],
        correctAnswer: 0
    },
    {
        question: "Qual é o nome do livro que conta a história de José no Egito?",
        answers: ["Gênesis", "Êxodo", "Levítico", "Juízes"],
        correctAnswer: 0
    },
    {
        question: "Quem foi o primeiro rei de Israel?",
        answers: ["Saul", "Davi", "Salomão", "Ezequias"],
        correctAnswer: 0
    },
    {
        question: "Quantos capítulos tem o livro de Salmos?",
        answers: ["150", "120", "100", "200"],
        correctAnswer: 0
    }
];

let currentQuestionIndex = 0;
let score = 0;
let timer = 60;
let countdownInterval;

// Função para iniciar o quiz
function startQuiz() {
    loadQuestion();
    startTimer();
}

// Carregar uma pergunta
function loadQuestion() {
    const currentQuestion = questions[currentQuestionIndex];
    document.getElementById('question').textContent = currentQuestion.question;
    document.getElementById('answer1').textContent = currentQuestion.answers[0];
    document.getElementById('answer2').textContent = currentQuestion.answers[1];
    document.getElementById('answer3').textContent = currentQuestion.answers[2];
    document.getElementById('answer4').textContent = currentQuestion.answers[3];

    // Adicionar eventos de clique para as respostas
    const answerButtons = document.querySelectorAll('.answer-btn');
    answerButtons.forEach((button, index) => {
        button.onclick = () => checkAnswer(index);
    });
}

// Checar se a resposta está correta
function checkAnswer(selectedIndex) {
    const currentQuestion = questions[currentQuestionIndex];
    if (selectedIndex === currentQuestion.correctAnswer) {
        score++;
    }

    currentQuestionIndex++;
    if (currentQuestionIndex < questions.length) {
        loadQuestion();
    } else {
        endQuiz();
    }
}

// Função para iniciar o temporizador
function startTimer() {
    countdownInterval = setInterval(() => {
        timer--;
        document.getElementById('countdown').textContent = timer;

        if (timer <= 0) {
            clearInterval(countdownInterval);
            endQuiz();
        }
    }, 1000);
}

// Finalizar o quiz
function endQuiz() {
    clearInterval(countdownInterval);
    document.getElementById('question-container').classList.add('hidden');
    document.getElementById('answers-container').classList.add('hidden');
    document.getElementById('result-container').classList.remove('hidden');
    document.getElementById('final-score').textContent = `Você acertou ${score} de ${questions.length} perguntas!`;

    const finalMessage = score > 10 ? "Parabéns, você ganhou o quiz!" : "Você perdeu, tente novamente!";
    document.getElementById('final-message').textContent = finalMessage;

    // Mostrar a mensagem final
    if (score > 10) {
        document.getElementById('final-message').style.color = 'green';
    } else {
        document.getElementById('final-message').style.color = 'red';
    }
}

// Reiniciar o quiz
document.getElementById('restart-btn').addEventListener('click', function() {
    score = 0;
    currentQuestionIndex = 0;
    timer = 60;
    document.getElementById('question-container').classList.remove('hidden');
    document.getElementById('answers-container').classList.remove('hidden');
    document.getElementById('result-container').classList.add('hidden');
    startQuiz();
});

// Iniciar o quiz ao carregar a página
startQuiz();
