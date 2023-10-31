package com.example.androidproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataTypeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataTypeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DataTypeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataTypeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataTypeFragment newInstance(String param1, String param2) {
        DataTypeFragment fragment = new DataTypeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_type, container, false);
        TextView dataTypeDescription = view.findViewById(R.id.dataTypeDescription);
        ListView listView = view.findViewById(R.id.dataTypeList);
        ArrayList<DataTypeItems> dataTypeItems = new ArrayList<>();
        dataTypeItems.add(new DataTypeItems("Accounting", "Accounting, also known as accountancy, is the processing of information about economic entities, such as businesses and corporations"));
        dataTypeItems.add(new DataTypeItems("Engineering", "Engineering is the practice of using natural science, mathematics, and the engineering design process to solve technical problems, increase efficiency and productivity, and improve systems."));
        dataTypeItems.add(new DataTypeItems("Computer Science", "Fundamental areas of computer science Computer science is the study of computation, information, and automation. Computer science spans theoretical disciplines to applied disciplines. Though more often considered an academic discipline, computer science is closely related to computer programming."));
        dataTypeItems.add(new DataTypeItems("Mathematics", "Mathematics is an area of knowledge that includes the topics of numbers, formulas and related structures, shapes and the spaces in which they are contained, and quantities and their changes."));
        dataTypeItems.add(new DataTypeItems("Mechanical Engineering", "Mechanical engineering is the study of physical machines that may involve force and movement. It is an engineering branch that combines engineering physics and mathematics principles with materials science, to design, analyze, manufacture, and maintain mechanical systems."));
        dataTypeItems.add(new DataTypeItems("Economics", "Economics is a social science that studies the production, distribution, and consumption of goods and services. Economics focuses on the behaviour and interactions of economic agents and how economies work."));
        dataTypeItems.add(new DataTypeItems("Biology", "Biology is the scientific study of life. It is a natural science with a broad scope but has several unifying themes that tie it together as a single, coherent field. For instance, all organisms are made up of cells that process hereditary information encoded in genes, which can be transmitted to future generations."));
        dataTypeItems.add(new DataTypeItems("Philosophy", "Philosophy is a systematic study of general and fundamental questions concerning topics like existence, reason, knowledge, value, mind, and language. It is a rational and critical inquiry that reflects on its own methods and assumptions."));

        dataTypeItems.add(new DataTypeItems("Marketing", "Marketing is the process of identifying customers and \"creating, communicating, delivering, and exchanging\" goods and services for the satisfaction and retention of those customers. It is one of the primary components of business management and commerce."));
        dataTypeItems.add(new DataTypeItems("Chemical Engineering", "Chemical engineering is an engineering field which deals with the study of operation and design of chemical plants as well as methods of improving production. Chemical engineers develop economical commercial processes to convert raw materials into useful products."));
        dataTypeItems.add(new DataTypeItems("Social Science", "Social science is one of the branches of science, devoted to the study of societies and the relationships among individuals within those societies. The term was formerly used to refer to the field of sociology, the original \"science of society\", established in the 19th century."));
        dataTypeItems.add(new DataTypeItems("Criminology", "Criminology is the interdisciplinary study of crime and deviant behaviour. Criminology is a multidisciplinary field in both the behavioural and social sciences, which draws primarily upon the research of sociologists, political scientists, economists, legal sociologists, psychologists, philosophers, psychiatrists, social workers, biologists, social anthropologists, scholars of law and jurisprudence, as well as the processes that define administration of justice and the criminal justice system."));
        dataTypeItems.add(new DataTypeItems("Chemistry", "Chemistry is the scientific study of the properties and behavior of matter. It is a physical science under natural sciences that covers the elements that make up matter to the compounds made of atoms, molecules and ions: their composition, structure, properties, behavior and the changes they undergo during a reaction with other substances. Chemistry also addresses the nature of chemical bonds in chemical compounds."));
        dataTypeItems.add(new DataTypeItems("Architectural Technology", "Architectural technology, or building technology, is the application of technology to the design of buildings. It is a component of architecture and building engineering and is sometimes viewed as a distinct discipline or sub-category."));


        //Method 1) use an existing adapter
//        ArrayAdapter adapter = new ArrayAdapter(getContext(),
//                android.R.layout.simple_list_item_1, dataTypeItems);
        //Method 2) user a custom adapter
        CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), dataTypeItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               dataTypeDescription
                       .setText(((DataTypeItems)listView.getItemAtPosition(i)).getDescription());
            }
        });
        return view;
    }
}