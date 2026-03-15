void main() {

}

public class Date {

    private int month;
    private int day;
    private int year;
    private int[] daysOfEachMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int month() {
        return this.month;
    }

    public int day() {
        return this.day;
    }

    public int year() {
        return this.year;
    }

    public String toString() {
        return (day + "/" + month + "/" + year);
    }

    public boolean before(Date other) {
        if (this.year < other.year())
            return true;
        if (this.year > other.year())
            return false;
        if (this.month < other.month())
            return true;
        if (this.month > other.month())
            return false;
        return this.day < other.day();
    }

    public int daysSinceBeginYear() {
        int soma = 0;
        for (int i = 0; i < this.month - 1; i++) {
            soma += this.daysOfEachMonth[i];
        }
        return soma + this.day;
    }

    public int daysUntilEndYear() {
        int soma = this.daysOfEachMonth[this.month - 1] - this.day;
        for (int i = this.month; i < 12; i++) {
            soma += this.daysOfEachMonth[i];
        }
        return soma;
    }

    public int daysBetween(Date other) {
        if (this.year == other.year()) {
            return Math.abs(this.daysSinceBeginYear() - other.daysSinceBeginYear());
        }
        Date first = this.before(other) ? this : other;
        Date second = this.before(other) ? other : this;
        int soma = first.daysUntilEndYear();
        for (int i = first.year() + 1; i < second.year(); i++) {
            soma += 365;
        }
        soma += second.daysSinceBeginYear();
        return soma;
    }
}