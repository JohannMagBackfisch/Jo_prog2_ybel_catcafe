package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatCafeTest {

    @Test
    void EmptyCafe_GettingCatCount_ReturnZero() {

        CatCafe cafe = new CatCafe();

        long result = cafe.getCatCount();

        assertEquals(0, result);
    }

    @Test
    void OneCat_AddingCat_CatCountIsOne() {

        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Snickers", 4);

        cafe.addCat(cat);

        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void MultipleCats_AddingCats_CorrectCatCountReturned() {

        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("Mars", 4));
        cafe.addCat(new FelineOverLord("Lunaria", 3));
        cafe.addCat(new FelineOverLord("Leon", 5));

        assertEquals(3, cafe.getCatCount());
    }

    @Test
    void CafeWithCats_SearchingExistingName_CorrectCatReturned() {

        CatCafe cafe = new CatCafe();
        FelineOverLord kit = new FelineOverLord("Kit", 3);
        cafe.addCat(new FelineOverLord("Melone", 4));
        cafe.addCat(kit);

        FelineOverLord result = cafe.getCatByName("Kit");

        assertEquals(kit, result);
    }

    @Test
    void CafeWithCats_SearchingNonExistingName_ReturnNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Bars", 4));

        FelineOverLord result = cafe.getCatByName("Garfield");

        assertNull(result);
    }

    @Test
    void givenNullName_SearchingCatByName_ReturnNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Milky", 4));

        FelineOverLord result = cafe.getCatByName(null);

        assertNull(result);
    }

    @Test
    void CafeWithMatchingWeight_SearchingWeight_CorrectCatReturned() {

        CatCafe cafe = new CatCafe();
        FelineOverLord mario = new FelineOverLord("Mario", 3);
        cafe.addCat(new FelineOverLord("Luigi", 7));
        cafe.addCat(mario);

        FelineOverLord result = cafe.getCatByWeight(2, 4);

        assertEquals(mario, result);
    }

    @Test
    void CafeWithoutMatchingWeight_SearchingWeight_ReturnNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Bailo", 4));

        FelineOverLord result = cafe.getCatByWeight(10, 20);

        assertNull(result);
    }

    @Test
    void EmptyCafe_SearchingCatByName_ReturnNull() {

        CatCafe cafe = new CatCafe();

        FelineOverLord result = cafe.getCatByName("Wario");

        assertNull(result);
    }

    @Test
    void NullCat_AddingCat_thenThrowException() {

        CatCafe cafe = new CatCafe();

        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }
}
