package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FillHardDiskTest {

    @Test
    void tests() {
        assertEquals(3, FillHardDisk.save(new int[]{4, 4, 4, 3, 3}, 12), "sizes = [4, 4, 4, 3, 3], hd = 12");
        assertEquals(2, FillHardDisk.save(new int[]{4, 4, 4, 3, 3}, 11), "sizes = [4, 4, 4, 3, 3], hd = 11");
        assertEquals(6, FillHardDisk.save(new int[]{4, 8, 15, 16, 23, 42}, 108), "sizes = [4, 8, 15, 16, 23, 42], hd = 108");
        assertEquals(1, FillHardDisk.save(new int[]{13}, 13), "sizes = [13], hd = 13");
        assertEquals(4, FillHardDisk.save(new int[]{1, 2, 3, 4}, 250), "sizes = [1, 2, 3, 4], hd = 250");
        assertEquals(1, FillHardDisk.save(new int[]{100}, 500), "sizes = [100], hd = 500");
        assertEquals(0, FillHardDisk.save(new int[]{11, 13, 15, 17, 19}, 8), "sizes = [11, 13, 15, 17, 19], hd = 8");
        assertEquals(0, FillHardDisk.save(new int[]{45}, 12), "sizes = [45], hd = 12");
    }

}