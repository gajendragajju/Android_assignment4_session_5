import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private String selectedName = "";
    private String[] nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nameList = getResources().getStringArray(R.array.name_list);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nameList));

        registerForContextMenu(getListView());

    }

    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {

        AdapterContextMenuInfo adapInfo = (AdapterContextMenuInfo) item
                .getMenuInfo();
        selectedName = nameList[(int) adapInfo.id];

        switch (item.getItemId()) {
        case R.id.view:
            Toast.makeText(MainActivity.this,
                    "You have pressed View Context Menu for " + selectedName,
                    Toast.LENGTH_LONG).show();
            return true;
        case R.id.save:
            Toast.makeText(MainActivity.this,
                    "You have pressed Save Context Menu for " + selectedName,
                    Toast.LENGTH_LONG).show();
            return true;
        case R.id.edit:
            Toast.makeText(MainActivity.this,
                    "You have pressed Edit Context Menu for " + selectedName,
                    Toast.LENGTH_LONG).show();
            return true;
        case R.id.delete:
            Toast.makeText(MainActivity.this,
                    "You have pressed Delete Context Menu for " + selectedName,
                    Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}