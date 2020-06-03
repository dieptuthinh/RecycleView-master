package vn.edu.ntu.tuongnghi.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.edu.ntu.tuongnghi.controller.ICartController;
import vn.edu.ntu.tuongnghi.model.Product;

public class ShoppingCartActivity extends AppCompatActivity {
    TextView txtShoppingCart;
    ICartController controller;
    Button buttonDEL,buttonOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        controller = (ICartController) getApplication();
        addView();
        addEvent();
    }

    private void addView() {
        txtShoppingCart = findViewById(R.id.textCart);
        buttonDEL = findViewById(R.id.buttonDEL);
        buttonOK = findViewById(R.id.buttonOK);
        displayShoppingCart();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_shopping, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_close1:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }



    private void displayShoppingCart() {
        List<Product> shoppingCart;
        shoppingCart = controller.getShoppingCart();
        StringBuilder builder = new StringBuilder();
        for(Product p:shoppingCart) {
            builder.append(p.getName()).append("\t\t").append(p.getPrice()).append("vnd\n");
        }
        if(builder.toString().length() > 0)
            txtShoppingCart.setText(builder.toString());
        else
            txtShoppingCart.setText("Không có mặt hàng nào trong giỏ hàng");
    }

    private void addEvent()
    {
        buttonDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtShoppingCart.setText("Không có mặt hàng nào trong giỏ hàng");
            }
        });

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtShoppingCart.setText("Không có mặt hàng nào trong giỏ hàng");
                Toast.makeText(getApplicationContext(),"Ban da mua thanh cong",Toast.LENGTH_SHORT).show();
            }
        });
    }


}


//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        addView();
//        addEvent();
//    }
//
//    private void addView()
//    {
//        edtTen = findViewById(R.id.edtTen);
//        edtNgaySinh = findViewById(R.id.edtNgaySinh);
//        RGGioiTinh = findViewById(R.id.RGGioiTinh);
//        CBXemPhim = findViewById(R.id.CBXemPhim);
//        CBNgheNhac = findViewById(R.id.CBNgheNhac);
//        CBCafe = findViewById(R.id.CBCafe);
//        CBONha = findViewById(R.id.CBONha);
//        CBNauAn = findViewById(R.id.CBNauAn);
//        edtSoThichKhac = findViewById(R.id.edtSoThichKhac);
//        BTXacNhan = findViewById(R.id.BTXacNhan);
//    }
//
//    private void addEvent()
//    {
//        BTXacNhan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                XacNhan();
//            }
//        });
//    }
//
//    private void XacNhan()
//    {
//        TXacNhan = edtTen.getText().toString() + "\n" + "Ngày sinh: " + edtNgaySinh.getText().toString()
//                + "\n" + "Giới tính: ";
//        if (RGGioiTinh.getCheckedRadioButtonId() == R.id.radioNam )
//            TXacNhan += "Nam" + "\n" + "Sở thích: ";
//        else
//            TXacNhan += "Nữ" + "\n" + "Sở thích: ";
//        if (CBXemPhim.isChecked())
//            TXacNhan += "Xem phim; ";
//        if (CBNgheNhac.isChecked())
//            TXacNhan += "Nghe nhạc; ";
//        if (CBCafe.isChecked())
//            TXacNhan += "Đi cà phê với bạn; ";
//        if (CBONha.isChecked())
//            TXacNhan += "Ở nhà một mình; ";
//        if (CBNauAn.isChecked())
//            TXacNhan += "Vào bếp nấu ăn; ";
//
//        TXacNhan += edtSoThichKhac.getText().toString();
//        Toast.makeText(getApplicationContext(), TXacNhan, Toast.LENGTH_LONG).show();
//    }
