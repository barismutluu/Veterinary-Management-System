PGDMP      
                |         	   veteriner    16.2    16.2 G    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17279 	   veteriner    DATABASE     �   CREATE DATABASE veteriner WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE veteriner;
                postgres    false            �            1259    17786    animals    TABLE     �  CREATE TABLE public.animals (
    animal_id bigint NOT NULL,
    animal_breed character varying(255) NOT NULL,
    animal_colour character varying(255) NOT NULL,
    animal_date_of_birth date NOT NULL,
    animal_gender character varying(255) NOT NULL,
    animal_name character varying(255) NOT NULL,
    animal_species character varying(255) NOT NULL,
    customer_id integer NOT NULL
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    17784    animals_animal_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.animals_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.animals_animal_id_seq;
       public          postgres    false    217            �           0    0    animals_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.animals_animal_id_seq OWNED BY public.animals.animal_id;
          public          postgres    false    215            �            1259    17785    animals_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.animals_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.animals_customer_id_seq;
       public          postgres    false    217            �           0    0    animals_customer_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.animals_customer_id_seq OWNED BY public.animals.customer_id;
          public          postgres    false    216            �            1259    17798    appointment    TABLE     �   CREATE TABLE public.appointment (
    appointment_id bigint NOT NULL,
    appointment_date_time timestamp(6) without time zone NOT NULL,
    animal_id integer NOT NULL,
    doctor_id integer NOT NULL
);
    DROP TABLE public.appointment;
       public         heap    postgres    false            �            1259    17796    appointment_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointment_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.appointment_animal_id_seq;
       public          postgres    false    221            �           0    0    appointment_animal_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.appointment_animal_id_seq OWNED BY public.appointment.animal_id;
          public          postgres    false    219            �            1259    17795    appointment_appointment_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointment_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.appointment_appointment_id_seq;
       public          postgres    false    221            �           0    0    appointment_appointment_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.appointment_appointment_id_seq OWNED BY public.appointment.appointment_id;
          public          postgres    false    218            �            1259    17797    appointment_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointment_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.appointment_doctor_id_seq;
       public          postgres    false    221            �           0    0    appointment_doctor_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.appointment_doctor_id_seq OWNED BY public.appointment.doctor_id;
          public          postgres    false    220            �            1259    17808    availabledate    TABLE     �   CREATE TABLE public.availabledate (
    availabledate_id bigint NOT NULL,
    availabledate date NOT NULL,
    doctor_id integer NOT NULL
);
 !   DROP TABLE public.availabledate;
       public         heap    postgres    false            �            1259    17806 "   availabledate_availabledate_id_seq    SEQUENCE     �   CREATE SEQUENCE public.availabledate_availabledate_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.availabledate_availabledate_id_seq;
       public          postgres    false    224            �           0    0 "   availabledate_availabledate_id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.availabledate_availabledate_id_seq OWNED BY public.availabledate.availabledate_id;
          public          postgres    false    222            �            1259    17807    availabledate_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.availabledate_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.availabledate_doctor_id_seq;
       public          postgres    false    224                        0    0    availabledate_doctor_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.availabledate_doctor_id_seq OWNED BY public.availabledate.doctor_id;
          public          postgres    false    223            �            1259    17816 	   customers    TABLE     F  CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    customer_address character varying(255) NOT NULL,
    customer_city character varying(255) NOT NULL,
    customer_mail character varying(255) NOT NULL,
    customer_name character varying(255) NOT NULL,
    customer_phone character varying(255) NOT NULL
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    17815    customers_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.customers_customer_id_seq;
       public          postgres    false    226                       0    0    customers_customer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;
          public          postgres    false    225            �            1259    17825    doctors    TABLE     8  CREATE TABLE public.doctors (
    doctor_id bigint NOT NULL,
    doctor_address character varying(255) NOT NULL,
    doctor_city character varying(255) NOT NULL,
    doctor_mail character varying(255) NOT NULL,
    doctor_name character varying(255) NOT NULL,
    doctor_phone character varying(255) NOT NULL
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    17824    doctors_doctor_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.doctors_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.doctors_doctor_id_seq;
       public          postgres    false    228                       0    0    doctors_doctor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.doctors_doctor_id_seq OWNED BY public.doctors.doctor_id;
          public          postgres    false    227            �            1259    17835    vaccine    TABLE     ,  CREATE TABLE public.vaccine (
    vaccine_id bigint NOT NULL,
    vaccine_code character varying(255),
    vaccine_name character varying(255),
    vaccine_protection_finish_date date,
    avaccine_protection_start_date date,
    animal_id integer NOT NULL,
    vaccine_protection_start_date date
);
    DROP TABLE public.vaccine;
       public         heap    postgres    false            �            1259    17834    vaccine_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccine_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.vaccine_animal_id_seq;
       public          postgres    false    231                       0    0    vaccine_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.vaccine_animal_id_seq OWNED BY public.vaccine.animal_id;
          public          postgres    false    230            �            1259    17833    vaccine_vaccine_id_seq    SEQUENCE        CREATE SEQUENCE public.vaccine_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.vaccine_vaccine_id_seq;
       public          postgres    false    231                       0    0    vaccine_vaccine_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.vaccine_vaccine_id_seq OWNED BY public.vaccine.vaccine_id;
          public          postgres    false    229            8           2604    17789    animals animal_id    DEFAULT     v   ALTER TABLE ONLY public.animals ALTER COLUMN animal_id SET DEFAULT nextval('public.animals_animal_id_seq'::regclass);
 @   ALTER TABLE public.animals ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    215    217    217            9           2604    17790    animals customer_id    DEFAULT     z   ALTER TABLE ONLY public.animals ALTER COLUMN customer_id SET DEFAULT nextval('public.animals_customer_id_seq'::regclass);
 B   ALTER TABLE public.animals ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    216    217    217            :           2604    17801    appointment appointment_id    DEFAULT     �   ALTER TABLE ONLY public.appointment ALTER COLUMN appointment_id SET DEFAULT nextval('public.appointment_appointment_id_seq'::regclass);
 I   ALTER TABLE public.appointment ALTER COLUMN appointment_id DROP DEFAULT;
       public          postgres    false    221    218    221            ;           2604    17802    appointment animal_id    DEFAULT     ~   ALTER TABLE ONLY public.appointment ALTER COLUMN animal_id SET DEFAULT nextval('public.appointment_animal_id_seq'::regclass);
 D   ALTER TABLE public.appointment ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    221    219    221            <           2604    17803    appointment doctor_id    DEFAULT     ~   ALTER TABLE ONLY public.appointment ALTER COLUMN doctor_id SET DEFAULT nextval('public.appointment_doctor_id_seq'::regclass);
 D   ALTER TABLE public.appointment ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    221    220    221            =           2604    17811    availabledate availabledate_id    DEFAULT     �   ALTER TABLE ONLY public.availabledate ALTER COLUMN availabledate_id SET DEFAULT nextval('public.availabledate_availabledate_id_seq'::regclass);
 M   ALTER TABLE public.availabledate ALTER COLUMN availabledate_id DROP DEFAULT;
       public          postgres    false    222    224    224            >           2604    17812    availabledate doctor_id    DEFAULT     �   ALTER TABLE ONLY public.availabledate ALTER COLUMN doctor_id SET DEFAULT nextval('public.availabledate_doctor_id_seq'::regclass);
 F   ALTER TABLE public.availabledate ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    223    224    224            ?           2604    17819    customers customer_id    DEFAULT     ~   ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);
 D   ALTER TABLE public.customers ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    225    226    226            @           2604    17828    doctors doctor_id    DEFAULT     v   ALTER TABLE ONLY public.doctors ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctors_doctor_id_seq'::regclass);
 @   ALTER TABLE public.doctors ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    228    227    228            A           2604    17838    vaccine vaccine_id    DEFAULT     x   ALTER TABLE ONLY public.vaccine ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccine_vaccine_id_seq'::regclass);
 A   ALTER TABLE public.vaccine ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    229    231    231            B           2604    17839    vaccine animal_id    DEFAULT     v   ALTER TABLE ONLY public.vaccine ALTER COLUMN animal_id SET DEFAULT nextval('public.vaccine_animal_id_seq'::regclass);
 @   ALTER TABLE public.vaccine ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    231    230    231            �          0    17786    animals 
   TABLE DATA           �   COPY public.animals (animal_id, animal_breed, animal_colour, animal_date_of_birth, animal_gender, animal_name, animal_species, customer_id) FROM stdin;
    public          postgres    false    217   3V       �          0    17798    appointment 
   TABLE DATA           b   COPY public.appointment (appointment_id, appointment_date_time, animal_id, doctor_id) FROM stdin;
    public          postgres    false    221   �W       �          0    17808    availabledate 
   TABLE DATA           S   COPY public.availabledate (availabledate_id, availabledate, doctor_id) FROM stdin;
    public          postgres    false    224   (X       �          0    17816 	   customers 
   TABLE DATA              COPY public.customers (customer_id, customer_address, customer_city, customer_mail, customer_name, customer_phone) FROM stdin;
    public          postgres    false    226   pX       �          0    17825    doctors 
   TABLE DATA           q   COPY public.doctors (doctor_id, doctor_address, doctor_city, doctor_mail, doctor_name, doctor_phone) FROM stdin;
    public          postgres    false    228   Z       �          0    17835    vaccine 
   TABLE DATA           �   COPY public.vaccine (vaccine_id, vaccine_code, vaccine_name, vaccine_protection_finish_date, avaccine_protection_start_date, animal_id, vaccine_protection_start_date) FROM stdin;
    public          postgres    false    231   �Z                  0    0    animals_animal_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.animals_animal_id_seq', 10, true);
          public          postgres    false    215                       0    0    animals_customer_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.animals_customer_id_seq', 1, false);
          public          postgres    false    216                       0    0    appointment_animal_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.appointment_animal_id_seq', 1, false);
          public          postgres    false    219                       0    0    appointment_appointment_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.appointment_appointment_id_seq', 6, true);
          public          postgres    false    218            	           0    0    appointment_doctor_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.appointment_doctor_id_seq', 1, false);
          public          postgres    false    220            
           0    0 "   availabledate_availabledate_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.availabledate_availabledate_id_seq', 8, true);
          public          postgres    false    222                       0    0    availabledate_doctor_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.availabledate_doctor_id_seq', 1, false);
          public          postgres    false    223                       0    0    customers_customer_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.customers_customer_id_seq', 11, true);
          public          postgres    false    225                       0    0    doctors_doctor_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 6, true);
          public          postgres    false    227                       0    0    vaccine_animal_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.vaccine_animal_id_seq', 1, false);
          public          postgres    false    230                       0    0    vaccine_vaccine_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.vaccine_vaccine_id_seq', 10, true);
          public          postgres    false    229            D           2606    17794    animals animals_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    217            F           2606    17805    appointment appointment_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (appointment_id);
 F   ALTER TABLE ONLY public.appointment DROP CONSTRAINT appointment_pkey;
       public            postgres    false    221            H           2606    17814     availabledate availabledate_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.availabledate
    ADD CONSTRAINT availabledate_pkey PRIMARY KEY (availabledate_id);
 J   ALTER TABLE ONLY public.availabledate DROP CONSTRAINT availabledate_pkey;
       public            postgres    false    224            J           2606    17823    customers customers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    226            L           2606    17832    doctors doctors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (doctor_id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    228            N           2606    17843    vaccine vaccine_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.vaccine
    ADD CONSTRAINT vaccine_pkey PRIMARY KEY (vaccine_id);
 >   ALTER TABLE ONLY public.vaccine DROP CONSTRAINT vaccine_pkey;
       public            postgres    false    231            P           2606    17854 '   appointment fk51y2ce12yp0g0hgsa39p2u9jq    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fk51y2ce12yp0g0hgsa39p2u9jq FOREIGN KEY (doctor_id) REFERENCES public.doctors(doctor_id);
 Q   ALTER TABLE ONLY public.appointment DROP CONSTRAINT fk51y2ce12yp0g0hgsa39p2u9jq;
       public          postgres    false    228    221    4684            R           2606    17859 )   availabledate fk527inmlaiv99f7yexjq8f53wr    FK CONSTRAINT     �   ALTER TABLE ONLY public.availabledate
    ADD CONSTRAINT fk527inmlaiv99f7yexjq8f53wr FOREIGN KEY (doctor_id) REFERENCES public.doctors(doctor_id);
 S   ALTER TABLE ONLY public.availabledate DROP CONSTRAINT fk527inmlaiv99f7yexjq8f53wr;
       public          postgres    false    228    4684    224            O           2606    17844 #   animals fkb36lt3kj4mrbdx5btxmp4j60n    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n;
       public          postgres    false    217    226    4682            S           2606    17864 #   vaccine fkcphlsnwa208me208efvjl8mi7    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccine
    ADD CONSTRAINT fkcphlsnwa208me208efvjl8mi7 FOREIGN KEY (animal_id) REFERENCES public.animals(animal_id);
 M   ALTER TABLE ONLY public.vaccine DROP CONSTRAINT fkcphlsnwa208me208efvjl8mi7;
       public          postgres    false    217    4676    231            Q           2606    17849 '   appointment fkdy3k7vnx8icftprffg2q9y896    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fkdy3k7vnx8icftprffg2q9y896 FOREIGN KEY (animal_id) REFERENCES public.animals(animal_id);
 Q   ALTER TABLE ONLY public.appointment DROP CONSTRAINT fkdy3k7vnx8icftprffg2q9y896;
       public          postgres    false    4676    217    221            �   �  x�M�An�0EףS� Q!Jr�.')� �]u3��a��dc�2=M�UF�����?>~Jx0
&�&rPWu[Vu)��D#Z�����t'�E}���dR�Qd��)�,jx� �Ѣ�������k�j_VM�d��[�L���rG��a���]6��Nh�x�x����O9��ɲ��G����0�i����ӛ���CS����x�I�b����^�i{�3/l4:�fl����I!f=ag���;�G������W�)�U�0�
S����3�LG("ޖ�>�A{gb�7����ĳ���c-|u���ڣ̢��z�4N������JZ��3������XŚ�n�Ʉc�ҀJQY�ږ�o����w��sEF�~�J���{�Ǉ�(�����      �   K   x�U���0��]E���B�u�GDbi#-�F��l��l$(�\S8�\⍘rK�/�*����oE�CU?��"      �   8   x�U�� ��]/	��~aۡ�Q�	�z+Z�`�츍�3p��DpW��A�      �   �  x�UPˎ�0<w���+E�3�[�E{AZV,�ĥ�x2�q���k8s����3i�,�eWuW��7KB�����cןWmO�|��X�q���	n��(���(�j
ye�J4��8o�F��� �@��7x��n���h�ĺ�l���8�����z���1���l��[r!K(�x��~�bE�M]����E���wL~[�b�?�D/q�����w�c�ξ��y9�Ѳ�<�:RM-
�������1�	���������]ydxt�S�YcP�P�E�!�	�}�:��s~
��N����%�<��PU�X�̽�iM��Ú��^�q��_����,�����ོ�������FU�y�q8���.;e0�����\E�R&�      �   �   x�MN1n�0��Wh`��-kt;t�Ь][P\ےA���}G�U�����!�lYj�?��ݱf�u?P��D_q�s\NJ�,J�)�F[��o���%���<�mr�c�>Ǳ�����d���H�*�յ%5�U"��\��V$�2݈���=�P*T�\�臋�Nڮ��K)��3�~�i9����ˁnt��&	��}��`��WJ<*�(��B�BWd      �   �   x�m�1�0��>Jl'm�ЅtIABYj;qz��2���3�3�d�`�7Dɖ�`���|%|$�mI����_���D�#g���4�k��oU2����g\^i���C���"0^O�c�:�Z�� ��[Zqsz:#�e�JF     