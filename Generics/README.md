<h1 align="center">Дженерики</h1>
Создайте иерархию животного царства на свое усмотрение - выбираем один тип (простейшие/губки/хордовые и т. д.), а далее наследуйте классы, отряды, семейства, роды и виды) - должна получиться иерархия в 6 уровней, выбор животных на ваш вкус, особо много создавать не нужно. Затем, для получившейся иерархии, выполняем следующее:

a. Создаем обобщенный класс Queue, представляющий из себя очередь фиксированного размера со стандартными методами очереди - add и get

b. Создаем методы produce и consume: первый метод должен возвращать upper bound generic очередь (например, наследники позвоночных) из n животных, которая будет генерироваться на ваше усмотрение и подаваться во второй метод. Consume будет их распределять в 2 или более lower bound очереди - например, родители кошек и родители змей, выбор типов также остаётся за вами.

c. Демонстрируем работу всех методов на конкретных собственных кейсах
