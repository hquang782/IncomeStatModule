/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unit;
import com.rentmotorbike.incomestat_by_monrth.dao.IncomeStatDAO;
import com.rentmotorbike.incomestat_by_monrth.models.IncomeStat;
import com.rentmotorbike.incomestat_by_monrth.models.Insurance;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
/**
 *
 * @author Hạ Quang
 */
public class TestIncometatistics {
    ArrayList<IncomeStat> test = new IncomeStatDAO().getIncomeStat();
    @Test
    public void testValidMonth() {
        // Kiểm tra kết quả khi truy vấn các tháng hợp lệ từ CSDL
        assertEquals(9755000, test.get(0).getRevenue()); // Doanh thu tháng 3 là 1000
        assertEquals(14650000, test.get(1).getRevenue()); // Doanh thu tháng 4 là 14650000
        assertEquals(4725000, test.get(2).getRevenue()); // Doanh thu tháng 5 là 4725000
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonth() {
        // Kiểm tra xử lý giá trị không hợp lệ
        test.get(12).getRevenue(); // Tháng không hợp lệ (không tồn tại trong CSDL)
    }
}
